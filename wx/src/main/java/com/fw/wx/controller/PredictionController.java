package com.fw.wx.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fw.core.entity.Prediction;
import com.fw.core.entity.PredictionCategory;
import com.fw.core.service.PredictionCategoryService;
import com.fw.core.service.PredictionService;
import com.fw.wx.domain.WxRes;
import com.fw.wx.domain.WxResType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yqf
 * @date 2020/11/13 上午10:02
 */
@RestController
@RequestMapping("/prediction")
public class PredictionController {

    @Autowired
    private PredictionCategoryService predictionCategoryService;
    @Autowired
    private PredictionService predictionService;

    @GetMapping("/category")
    public ResponseEntity<WxRes> findPredictionCategory(){
        List<PredictionCategory> list = predictionCategoryService.list();

        return  new ResponseEntity<>(new WxRes(WxResType.SUCCESS,list), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<WxRes> findPredictionText(@RequestBody Prediction prediction){
        QueryWrapper<Prediction> predictionQueryWrapper = new QueryWrapper<>();

        predictionQueryWrapper.setEntity(prediction);

        List<Prediction> list = predictionService.list(predictionQueryWrapper);



        return new ResponseEntity<>(new WxRes(WxResType.SUCCESS,list.get(0)),HttpStatus.OK);
    }
}
