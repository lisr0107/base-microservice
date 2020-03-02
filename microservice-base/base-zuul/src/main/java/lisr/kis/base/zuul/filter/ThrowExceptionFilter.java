package lisr.kis.base.zuul.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.util.ZuulRuntimeException;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ThrowExceptionFilter extends ZuulFilter {

	Logger loger = LoggerFactory.getLogger(ThrowExceptionFilter.class);
	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object run(){
		// TODO Auto-generated method stub
		loger.info("run error test ...");
		//RequestContext ctx = RequestContext.getCurrentContext();
		//RuntimeException re = new RuntimeException();
		//ctx.setThrowable(re);
      //  throw re;
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 9;
	}
	

}
