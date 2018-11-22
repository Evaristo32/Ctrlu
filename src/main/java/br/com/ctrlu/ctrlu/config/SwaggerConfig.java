package br.com.ctrlu.ctrlu.config;

import br.com.ctrlu.ctrlu.util.CtrluUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(CtrluUtil.PACOTE_DAS_CONTROLES))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
        CtrluUtil.NOME_DA_APLICACAO,
                CtrluUtil.DESCRICAO_DA_APLICACAO,
                CtrluUtil.VERSAO_DA_APLICACAO,
                CtrluUtil.TERMOS_DE_SERVICO,
                new Contact(CtrluUtil.NOME_DA_APLICACAO, CtrluUtil.EMAIL_DE_EXEMPLO, CtrluUtil.EMAIL_DA_APLICACAO),
                CtrluUtil.LICENSE_OF_API, CtrluUtil.URL_DA_API, Collections.emptyList());
    }
}

