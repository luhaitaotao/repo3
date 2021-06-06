package config;

import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration//指定当前类是配置类
@ComponentScan("com.itheima")//指定扫描的包
@Import({JdbcConfig.class,TransactionConfig.class})
@PropertySource("jdbc.properties")
@EnableTransactionManagement
public class SpringConfiguration {
}
