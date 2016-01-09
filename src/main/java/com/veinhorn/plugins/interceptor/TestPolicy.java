package com.veinhorn.plugins.interceptor;

import io.apiman.gateway.engine.beans.ApiRequest;
import io.apiman.gateway.engine.beans.ApiResponse;
import io.apiman.gateway.engine.policies.AbstractMappedPolicy;
import io.apiman.gateway.engine.policy.IPolicyChain;
import io.apiman.gateway.engine.policy.IPolicyContext;

/**
 * Created by veinhorn on 9.1.16.
 */
public class TestPolicy extends AbstractMappedPolicy<TestBean> {

    @Override
    protected Class<TestBean> getConfigurationClass() {
        return TestBean.class;
    }

    @Override
    protected void doApply(ApiRequest request, IPolicyContext context, TestBean bean,
                           IPolicyChain<ApiRequest> chain) {
        // some action

        super.doApply(request, context, bean, chain);
    }

    @Override
    protected void doApply(ApiResponse response, IPolicyContext context, TestBean bean,
                           IPolicyChain<ApiResponse> chain) {
        // some action

        super.doApply(response, context, bean, chain);
    }
}
