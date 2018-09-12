package com.thoughtworks.gw.filter;

public class SimpleFilter{}
//public class SimpleFilter extends ZuulFilter {
//
//  private static Logger log = LoggerFactory.getLogger(SimpleFilter.class);
//
//  @Override
//  public String filterType() {
//    return "pre";
//  }
//
//  @Override
//  public int filterOrder() {
//    return 1;
//  }
//
//  @Override
//  public boolean shouldFilter() {
//    return true;
//  }
//
//  @Override
//  public Object run() {
//    RequestContext ctx = RequestContext.getCurrentContext();
//    HttpServletRequest request = ctx.getRequest();
//
//    log.info(String.format("\n\n%s request to %s", request.getMethod(), request.getRequestURL().toString()));
//
//    return null;
//  }
//
//}
