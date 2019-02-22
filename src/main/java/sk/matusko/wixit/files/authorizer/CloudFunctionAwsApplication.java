package sk.matusko.wixit.files.authorizer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sk.matusko.wixit.files.authorizer.dto.AuthPolicy;
import sk.matusko.wixit.files.authorizer.dto.TokenAuthorizerContext;

import java.util.function.Function;

@SpringBootApplication
public class CloudFunctionAwsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudFunctionAwsApplication.class, args);
    }

    @Bean
    public Function<TokenAuthorizerContext, AuthPolicy> authorize() {
        return value -> {
            AuthPolicy authPolicy = new AuthPolicy();
            authPolicy.setPrincipalId("xyz");
            AuthPolicy.PolicyDocument policyDocument = new AuthPolicy.PolicyDocument();
            AuthPolicy.Statement statement = new AuthPolicy.Statement();
            statement.setAction("execute-api:Invoke");
            statement.setEffect("Allow");
            statement.addResource(value.getMethodArn());
            policyDocument.addStatement(statement);
            authPolicy.setPolicyDocument(policyDocument);

            return authPolicy;
        };
    }

}
