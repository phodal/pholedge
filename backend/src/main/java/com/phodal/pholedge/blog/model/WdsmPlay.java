package com.phodal.pholedge.blog.model;

import lombok.Value;

import java.util.ArrayList;

@Value
public class WdsmPlay {
    private float id;
    private String user;
    private String user_bio;
    private String title;
    private String slug;
    private String description;
    private String updated;
    private String content;
    private String featured_image;
    ArrayList < Object > categories = new ArrayList < Object > ();
    ArrayList < Object > related_posts = new ArrayList< Object >();
}
