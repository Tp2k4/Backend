package com.gms.gmshopbackend.controller;

import com.gms.gmshopbackend.response.RevenueResponse;
import com.gms.gmshopbackend.service.impl.RevenueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("${api.prefix}/revenue")
@RequiredArgsConstructor
public class RevenueController {

    private final RevenueService revenueService;
    @GetMapping("/alls")
    public ResponseEntity<?> getAllsRevenue(){

        try{
            List<RevenueResponse> list = revenueService.getAll();
            return new ResponseEntity<>(list, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @GetMapping("/date-date")
    public ResponseEntity<?> getRevenueByDateBetween(@RequestParam("start_date") LocalDate startDate,
                                                     @RequestParam("end_date") LocalDate endDate) {
        try{
            List<RevenueResponse> revenueResponses = revenueService.getRevenueByDate(startDate, endDate);
            return new ResponseEntity<>(revenueResponses, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/today-revenue")
    public ResponseEntity<?> getTodayRevenue() {
        try{
            return new ResponseEntity<>(revenueService.getTodayRevenue(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/last-six-month-revenue")
    public ResponseEntity<?> getLastSixMonthRevenue() {
        try{
            return new ResponseEntity<>(revenueService.getLastSixMonthRevenue(), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}








