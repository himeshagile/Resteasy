package org.resteasy;

import org.resteasy.specimpl.UriBuilderImpl;
import org.resteasy.spi.HttpOutputMessage;

/**
 * @author <a href="mailto:bill@burkecentral.com">Bill Burke</a>
 * @version $Revision: 1 $
 */
public class QueryParamMarshaller implements ParameterMarshaller {
    private String paramName;

    public QueryParamMarshaller(String paramName) {
        this.paramName = paramName;
    }

    public void marshall(Object object, UriBuilderImpl uri, HttpOutputMessage output) {
        uri.queryParam(paramName, object.toString());
    }
}