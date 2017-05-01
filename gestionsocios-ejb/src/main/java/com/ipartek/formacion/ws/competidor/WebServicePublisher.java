package com.ipartek.formacion.ws.competidor;

import javax.xml.ws.Endpoint;

public class WebServicePublisher {

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8180/test", new CompetidorServiceBeanSOAP());
    }

}