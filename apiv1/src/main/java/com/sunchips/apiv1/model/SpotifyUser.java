package com.sunchips.apiv1.model;


import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class SpotifyUser {


    private String country;
    private String displayName;
    private String email;
    private ExplicitContent explicit_content;
    private Map<String, String> externalUrls;
    private Followers followers;
    private String href;
    private String id;
    private List<Image> images;
    private String product;
    private String type;
    private String uri;
}