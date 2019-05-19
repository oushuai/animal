package com.oushuai.animal.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oushuai.animal.bean.Album;
import com.oushuai.animal.bean.Msg;
import com.oushuai.animal.bean.Photo;
import com.oushuai.animal.bean.vo.PhotoVo;
import com.oushuai.animal.service.AlbumService;
import com.oushuai.animal.service.CategoryService;
import com.oushuai.animal.service.PhotoService;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.converters.DateConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Controller
@RequestMapping("/photo")
public class PhotoController {

    @Autowired
    private PhotoService photoService;
    @Autowired
    private AlbumService albumService;
    @Value("${upload.root.server}")
    private String uploadRootServer;
    @Value("${image.context.address}")
    private String imageContext;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(@RequestParam(value = "albumId", required = false) Integer albumId, @RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
        PageHelper.startPage(pn, 5);
        List<Photo> photo = null;
        if (albumId == null) {
                List<PhotoVo> photoVos=new ArrayList<>();
                photo = photoService.list();
                if(photo!=null){
                    photo.forEach(p->{
                        Album album=albumService.getInfo(p.getAlbumId());
                        PhotoVo photoVo=new PhotoVo();
                        try {
                            BeanUtilsBean.getInstance().getConvertUtils().register(new DateConverter(new Date()), Date.class);
                            BeanUtils.copyProperties(photoVo,p);
                            photoVo.setAlbumName(album.getAlbumName());
                            photoVos.add(photoVo);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    });
                }
            model.addAttribute("list", photoVos);
            PageInfo page = new PageInfo(photoVos, 5);

            model.addAttribute("pageInfo", page);
        } else {
            photo=photoService.list(albumId);
            Album album = albumService.getInfo(albumId);
            model.addAttribute("album", album);
            model.addAttribute("list", photo);
            PageInfo page = new PageInfo(photo, 5);
            model.addAttribute("pageInfo", page);
        }

        return "photos/list";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Msg delete(Integer photoId, Integer albumId) {
        boolean del = photoService.delete(photoId, albumId);
        return del ? Msg.success() : Msg.fail();
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showAdd(@RequestParam(value = "albumId", required = false) Integer albumId, Model model) {
        model.addAttribute("albumId", albumId);
        return "photos/add";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String add(Photo photo, MultipartFile file, HttpServletRequest reqeust) {
        Msg uploadResult = uploadPhoto(file, reqeust);
        if (uploadResult.getCode() == 0) {
            photo.setCreateTime(new Date());
            photo.setPhotoDate(new Date());
            photo.setIsRecommend((byte) 0);
            photo.setIsDelete((byte) 0);
            photo.setPhotoUrl(uploadResult.getMsg());
            photoService.insert(photo);
            return "redirect:/photo/list?albumId=" + photo.getAlbumId();
        } else {
            return "redirect:/photo/add?albumId=" + photo.getAlbumId();
        }
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String showedit(@RequestParam(value = "albumId", required = true) Integer albumId, @RequestParam(value = "photoId", required = true) Integer photoId, Model model) {
        Photo photo = photoService.getPhoto(photoId);
        model.addAttribute("photo", photo);
        model.addAttribute("albumId", albumId);
        return "photos/edit";
    }

    @RequestMapping(value = "/doedit", method = RequestMethod.POST)
    public String edit(Photo photo) {
        photo.setUpdateTime(new Date());
        if (photoService.update(photo)) {
            return "redirect:/photo/list?albumId=" + photo.getAlbumId();
        } else {
            return "redirect:/photo/edit?albumId=" + photo.getAlbumId() + "&photoId=" + photo.getId();
        }
    }

    public Msg uploadPhoto(MultipartFile file, HttpServletRequest reqeust) {

        if (file == null || file.getSize() == 0) return Msg.fail();
        InputStream stream = null;
        try {
            stream = file.getInputStream();
        } catch (IOException e) {
            return Msg.fail();
        }
        String fileName = file.getOriginalFilename();
        String ext = fileName.split("\\.")[1];
        fileName = MessageFormat.format("{0}.{1}", UUID.randomUUID(), ext);
        uploadRootServer = reqeust.getServletContext().getRealPath("/WEB-INF/images/");
        File root = new File(uploadRootServer);
        if (!root.exists()) {
            root.mkdirs();
        }

        File savedFile = new File(uploadRootServer, fileName);
        FileOutputStream fis = null;
        try {
            fis = new FileOutputStream(savedFile);
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = stream.read(buffer)) != -1) {
                fis.write(buffer, 0, len);
            }
            Msg msg = new Msg();
            msg.setMsg(MessageFormat.format("{0}{1}", imageContext, fileName));
            return msg;
        } catch (Exception e) {
            e.printStackTrace();
            return Msg.fail();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}