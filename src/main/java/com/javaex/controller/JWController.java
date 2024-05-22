package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.JWService;
import com.javaex.util.JsonResult;
import com.javaex.vo.ReserveVo;

@RestController
public class JWController {

    @Autowired
    private JWService jwService;

    // 한 가게의 예약 리스트 정보 조회 
    @GetMapping("/api/jw/{bNo}")
    public JsonResult selectReserveList(@PathVariable("bNo") int bNo) {
        System.out.println("JWController.list");
    

        List<ReserveVo> reserveList = jwService.getReserveList(bNo);
        System.out.println(reserveList);

        return JsonResult.success(reserveList);
    }

    // 예약 정보 업데이트
    @PutMapping("/api/jw/{rsNo}")
    public JsonResult updateReserve(@PathVariable("rsNo") int rsNo, @RequestBody ReserveVo reserveVo) {
        System.out.println("JWController.updateReserve");

        reserveVo.setRsNo(rsNo);
        System.out.println(reserveVo);

        int count = jwService.exeUpdateReserve(reserveVo);

        if (count > 0) {
            return JsonResult.success(reserveVo);
        } else {
            return JsonResult.fail("Update failed");
        }
    }
}
