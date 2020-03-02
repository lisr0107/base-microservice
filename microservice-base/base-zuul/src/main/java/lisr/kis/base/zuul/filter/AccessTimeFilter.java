package lisr.kis.base.zuul.filter;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

/**
 * 利用网管过滤器实现限时访问的功能
 * @author admin
 *
 */
@Component
public class AccessTimeFilter extends ZuulFilter {

	@Value("${activetime.begin:0}")
	private int beginTime;
	
	@Value("${activetime.end:23}")
	private int endTime;
	
	
	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object run() throws ZuulException {
		// TODO Auto-generated method stub
		LocalTime begin = LocalTime.of(beginTime, 0);
		LocalTime end = LocalTime.of(endTime, 0);
		LocalTime now = LocalTime.now();
		if (now.isBefore(begin) || now.isAfter(end)) {
			
			throw new RuntimeException();
		}
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
		return 0;
	}

}
