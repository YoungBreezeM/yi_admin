package com.fw.wx;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fw.core.entity.Questions;
import com.fw.core.service.QuestionsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootTest
class WxApplicationTests {
    @Autowired
    private QuestionsService questionsService;
    @Autowired
    private WxMaService wxMaService;
    @Test
    void contextLoads() {

        QueryWrapper<Questions> objectQueryWrapper = new QueryWrapper<>();
        Questions questions = new Questions();
        questions.setCategoryId(2);
        objectQueryWrapper.setEntity(questions);

        List<Questions> list = questionsService.list(objectQueryWrapper);
        System.out.println(list);
    }

}
