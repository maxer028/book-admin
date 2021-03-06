package com.book.controller;

/**
 * @author dingshuangkun
 * @date on 2018/4/12.
 */

import com.book.service.NovelService;
import com.book.vo.NovelVO;
import com.mysql.query.QueryNovel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/novel")
public class NovelController {
    @Autowired
    private NovelService novelService;

    @RequestMapping("/insertChapter")
    @ResponseBody
    public void test(){
        novelService.insertChapter();
    }

    @RequestMapping("/insertContent")
    @ResponseBody
    public void testInsertContent(){
        novelService.insertContent();

    }

    @ResponseBody
    @CrossOrigin(origins = "*" ,maxAge = 360)
    @RequestMapping("/query")
    public List<NovelVO> getNovel(QueryNovel queryNovel){

        return novelService.queryNovel(queryNovel);
    }

    @ResponseBody
    @CrossOrigin(origins = "*" ,maxAge = 360)
    @RequestMapping("/query/ByAuthorOrTitle")
    public List<NovelVO> getNovel(@RequestParam("authorOrTitle") String authorOrTitle){
        if(StringUtils.isEmpty(authorOrTitle)){
            throw new RuntimeException("titleOrAuthor is null ");
        }
        return novelService.queryLikeByauthorOrTitle(authorOrTitle);
    }

}
