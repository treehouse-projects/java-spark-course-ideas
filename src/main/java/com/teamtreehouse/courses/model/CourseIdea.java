package com.teamtreehouse.courses.model;

import com.github.slugify.Slugify;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class CourseIdea {
    private String slug;
    private String title;
    private String creator;
    private Set<String> voters;

    public CourseIdea(String title, String creator) {
        voters = new HashSet<>();
        this.title = title;
        this.creator = creator;
        try {
            Slugify slugify = new Slugify();
            slug = slugify.slugify(title);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getTitle() {
        return title;
    }

    public String getCreator() {
        return creator;
    }

    public String getSlug() {
        return slug;
    }

    public boolean addVoter(String voterUserName) {
        return voters.add(voterUserName);
    }

    public int getVoteCount() {
        return voters.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseIdea that = (CourseIdea) o;

        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        return creator != null ? creator.equals(that.creator) : that.creator == null;

    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (creator != null ? creator.hashCode() : 0);
        return result;
    }
}
