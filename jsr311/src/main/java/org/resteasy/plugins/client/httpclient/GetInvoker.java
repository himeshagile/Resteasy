package org.resteasy.plugins.client.httpclient;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethodBase;
import org.apache.commons.httpclient.methods.GetMethod;

import javax.ws.rs.ext.ProviderFactory;
import java.lang.reflect.Method;

/**
 * @author <a href="mailto:bill@burkecentral.com">Bill Burke</a>
 * @version $Revision: 1 $
 */
public class GetInvoker extends HttpClientInvoker {
    public GetInvoker(HttpClient client, Class<?> declaring, Method method, ProviderFactory providerFactory) {
        super(client, declaring, method, providerFactory);
    }

    public HttpMethodBase createBaseMethod(String uri) {
        return new GetMethod(uri);
    }
}
