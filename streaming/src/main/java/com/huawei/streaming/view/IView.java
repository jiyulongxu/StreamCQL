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

package com.huawei.streaming.view;

import com.huawei.streaming.event.IEvent;

/**
 * 
 * <IView接口提供方法，将流或者视图中的新数据和过期数据发送给子视图。>
 * 
 */
public interface IView extends IViewable
{
    /**
     * <返回父视图>
     * @return 父视图
     */
    public IViewable getParent();
    
    /**
     * <设置父视图>
     * @param parent 父视图
     */
    public void setParent(IViewable parent);
    
    /**
     * <将新数据和过期数据发送给子视图>
     * @param newData 新数据
     * @param oldData 过期数据
     */
    void update(IEvent[] newData, IEvent[] oldData);
}
