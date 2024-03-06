package com.example.nexus.demo.service.serviceimpl;


import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.nexus.demo.dto.AdmissionDTO;
import com.example.nexus.demo.dto.PaymentDTO;
import com.example.nexus.demo.dto.PaymentTableDTO;
import com.example.nexus.demo.mapper.AdmissionsTableMapper;
import com.example.nexus.demo.mapper.PaymentMapper;
import com.example.nexus.demo.model.Payment;
import com.example.nexus.demo.model.AppUser;
import com.example.nexus.demo.repository.PaymentRepository;
import com.example.nexus.demo.repository.UserRepository;
import com.example.nexus.demo.service.AdmissionServices;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AdmissionServiceImpl implements AdmissionServices {
    private PaymentRepository pr;
    private UserRepository ur;
    public PaymentDTO addAdmissionDetails(PaymentDTO p){
        Payment pay=PaymentMapper.mapToPayment(p);
        Payment k=pr.save(pay);
        return PaymentMapper.mapToPaymentDTO(k);
    }
    
    public PaymentDTO admissionDetails(Long id){
        Payment k=pr.findById(id).orElse(null);
        return PaymentMapper.mapToPaymentDTO(k);
    }
    public void deleteAdmissionById(Long id){
        pr.deleteById(id);
    }
    public List<PaymentDTO> viewAllAdmissions(){
        List<Payment> arr=pr.findAll();
        List<PaymentDTO> answer=new ArrayList<>();
        for(Payment k:arr){
            answer.add(PaymentMapper.mapToPaymentDTO(k));
        }
        return answer;
    }
    public List<AdmissionDTO> coursesOfStudent(Integer id){
        AppUser u=ur.findById(id).orElse(null);
        List<Payment> answer=pr.findByUser(u);
        List<PaymentDTO> temp=new ArrayList<>();
        List<AdmissionDTO> kelvin=new ArrayList<>();
        for(Payment l:answer){
            temp.add(PaymentMapper.mapToPaymentDTO(l));
        }
        for(PaymentDTO l:temp){
            kelvin.add(AdmissionsTableMapper.mapToAdmissionsTable(l));
        }
        return kelvin;
    }
    public List<PaymentTableDTO> paymentOfStudent(Integer id){
        AppUser u=ur.findById(id).orElse(null);
        List<Payment> answer=pr.findByUser(u);
        List<PaymentDTO> temp=new ArrayList<>();
        List<PaymentTableDTO> kelvin=new ArrayList<>();
        for(Payment l:answer){
            temp.add(PaymentMapper.mapToPaymentDTO(l));
        }
        for(PaymentDTO l:temp){
            kelvin.add(PaymentMapper.mapToPaymentDisplay(l));
        }
        return kelvin;
    }

}
