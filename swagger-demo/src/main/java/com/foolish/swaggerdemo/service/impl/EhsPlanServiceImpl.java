package com.foolish.swaggerdemo.service.impl;

import com.foolish.swaggerdemo.entity.EhsPlan;
import com.foolish.swaggerdemo.mapper.EhsPlanMapper;
import com.foolish.swaggerdemo.service.IEhsPlanService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 计划任务表：根据检查频次自动生成 服务实现类
 * </p>
 *
 * @author cxf
 * @since 2020-01-19
 */
@Service
public class EhsPlanServiceImpl extends ServiceImpl<EhsPlanMapper, EhsPlan> implements IEhsPlanService {

}
