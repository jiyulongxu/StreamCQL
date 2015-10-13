/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.huawei.streaming.udfs;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Strings;

/**
 * 数据类型转换函数
 * 
 */
@UDFAnnotation(name = "totime")
public class ToTime extends UDF
{
    private static final long serialVersionUID = -4516472038115224500L;
    
    private static final Logger LOG = LoggerFactory.getLogger(ToTime.class);
    
    private final SimpleDateFormat formatter = new SimpleDateFormat(UDFConstants.TIME_FORMAT);
    
    /**
     * <默认构造函数>
     * @param config 参数
     */
    public ToTime(Map<String, String> config)
    {
        super(config);
        /*
         * 设置时间严格匹配
         */
        formatter.setLenient(false);
    }
    
    /**
     * 类型转换实现
     * @param s 待转换数据
     * @return 转换之后结果
     */
    public Time evaluate(String s)
    {
        if (Strings.isNullOrEmpty(s))
        {
            return null;
        }
        
        try
        {
            formatter.parse(s);
            return Time.valueOf(s);
        }
        catch (Exception e)
        {
            LOG.warn(EVALUATE_IGNORE_MESSAGE);
            return null;
        }
    }
}