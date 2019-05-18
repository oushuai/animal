package com.oushuai.animal.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oushuai.animal.bean.*;
import com.oushuai.animal.bean.vo.AblumVo;
import com.oushuai.animal.service.AlbumService;
import com.oushuai.animal.service.CategoryService;
import com.oushuai.animal.service.PhotoService;
import com.oushuai.animal.service.VideoService;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.ibatis.ognl.CollectionElementsAccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 *
 */
@RequestMapping("/album")
@Controller
public class AlbumController {

    @Autowired
    private AlbumService albumService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private PhotoService photoService;
    @Autowired
    private VideoService videoService;
    @Value("${image.context.address}")
    private String imageContext;

    @RequestMapping("/list")
    public String list(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
        PageHelper.startPage(pn, 5);
        List<Album> albums = albumService.list();
        List<AblumVo> albumList = new ArrayList<>();
        albums.forEach(a -> {
            Category category = categoryService.getInfoById(a.getCateId());
            AblumVo ablumVo = new AblumVo();
            if (category != null) {
                ablumVo.setCateName(category.getCateName());
            }
            try {

                BeanUtilsBean beanUtilsBean = new BeanUtilsBean();
                beanUtilsBean.getConvertUtils().register(new DateConverter(new Date()), Date.class);
                BeanUtils.copyProperties(ablumVo, a);

                List<Photo> ps=photoService.list(a.getId());
                if(ps!=null)ablumVo.setPhotoCount(ps.size());
                List<Video> vs=videoService.list(a.getId());
                if(vs!=null)ablumVo.setVideoCount(vs.size());

                albumList.add(ablumVo);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

        });

        model.addAttribute("list", albumList);
        PageInfo page = new PageInfo(albums, 5);
        model.addAttribute("pageInfo", page);
        return "album/list";
    }

    @GetMapping("/add")
    public String add(){
        return "/album/add";
    }
    @PostMapping("/submitadd")
    public String add(Album album, MultipartFile file, HttpServletRequest reqeust) {
        Msg uploadResult = uploadPhoto(file, reqeust);
        if (uploadResult.getCode() == 0) {
            album.setCreateTime(new Date());
            album.setUpdateTime(new Date());
            album.setSortNo((byte) 0);
            album.setAlbumUrl(uploadResult.getMsg());
            albumService.save(album);
            return "redirect:/album/list";
        }
        return "redirect:/album/add";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam(value="albumId",required=true) Integer albumId, Model model) {
        Album album = albumService.getInfo(albumId);
        model.addAttribute("album", album);
        model.addAttribute("albumId", albumId);
        return "/album/edit";
    }

    @PostMapping("/submitedit")
    public String edit(Album album, MultipartFile file, HttpServletRequest reqeust) {
        album.setUpdateTime(new Date());
        album.setSortNo((byte) 0);
       if(file!=null&& file.getSize()!=0){
           Msg uploadResult = uploadPhoto(file, reqeust);
           if (uploadResult.getCode() == 0) {
               album.setAlbumUrl(uploadResult.getMsg());
           }else{
               return "redirect:/album/edit?albumId=" + album.getId();
           }
       }
           albumService.update(album);
           return "redirect:/album/list";
    }

    @RequestMapping("/getAlbums")
    @ResponseBody
    public List<Album> getAlbums() {
        return albumService.list();
    }
    @RequestMapping("/delete")
    @ResponseBody
    public Msg delete(int albumId) {
        List<Photo> photos = photoService.list(albumId);
        boolean pDel = photoService.delete(photos);
        List<Video> videos = videoService.list(albumId);
        boolean vDel = videoService.delete(videos);
        if(pDel&vDel){

        }
        try {
            albumService.del(albumId);
            return Msg.success();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Msg.fail();
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
        String uploadRootServer = reqeust.getServletContext().getRealPath("/WEB-INF/images/");
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
