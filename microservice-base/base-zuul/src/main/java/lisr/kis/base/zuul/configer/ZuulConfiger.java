package lisr.kis.base.zuul.configer;

import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZuulConfiger {

	/**
	 * 自定义路由映射规则，把服务名servicename-v1映射为:/v1/servicename/,启用@Bean注释
	 * @return
	 */
	public PatternServiceRouteMapper serviceRouteMapper() {
		return new PatternServiceRouteMapper(
				"(?<name>^.+)-(?<version>v.+$)","${version}/${name}"
				);
	}
}
