package sk.matusko.wixit.files.authorizer;

import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;
import sk.matusko.wixit.files.authorizer.dto.AuthPolicy;
import sk.matusko.wixit.files.authorizer.dto.TokenAuthorizerContext;

public class AuthorizeHandler extends SpringBootRequestHandler<TokenAuthorizerContext, AuthPolicy> {

}
