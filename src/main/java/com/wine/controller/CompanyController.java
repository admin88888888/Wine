package com.wine.controller;
import com.wine.common.JsonBean;
import com.wine.dao.CompanyMapper;
import com.wine.entity.Company;
import com.wine.service.CompanyService;
import com.wine.util.JsonUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "公司信息", tags = "公司信息")
public class CompanyController {
    @Autowired
    private CompanyService companyService;
    @Autowired
    private CompanyMapper companyMapper;
    @CrossOrigin
    @GetMapping("/company/list.do")
    @ApiOperation(value = "认证企业", notes = "认证企业")
    public JsonBean findAllCompany(){
        List<Company> list = companyService.findByAll();
        return JsonUtil.createJsonBean(1000, null, list);
    }
    @CrossOrigin
    @GetMapping("/company/selectCompanyById.do")
    @ApiOperation(value = "获取酒水所属企业信息", notes = "获取酒水所属企业")
    public JsonBean selectCompanyById(@RequestParam("cid") int cid){

        Company company = companyMapper.selectByPrimaryKey(cid);
        return JsonUtil.createJsonBean(1000,null,company);
    }

}
