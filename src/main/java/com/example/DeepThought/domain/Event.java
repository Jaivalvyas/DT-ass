/*
 * Author Name: Jaival
 * Date: 25-05-2023
 * Createdd with IntelliJ IDEA Community Editiion
 */
package com.example.DeepThought.domain;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Arrays;

@Builder
@Document
public class Event {
    @Id
    private int uid;
    private String typedes;
    private String name;
    private String tagline;
    private LocalDateTime schedule;
    private String description;
    private String moderator;
    private String category;
    private String sub_category;
    private int rigor_rank;

    private byte[] image;
    private String type;
    private String imageName;
    private User attendees;

    public Event() {
    }

    public Event(int uid, String typedes, String name, String tagline, LocalDateTime schedule, String description, String moderator, String category, String sub_category, int rigor_rank, byte[] image, String type, String imageName, User attendees) {
        this.uid = uid;
        this.typedes = typedes;
        this.name = name;
        this.tagline = tagline;
        this.schedule = schedule;
        this.description = description;
        this.moderator = moderator;
        this.category = category;
        this.sub_category = sub_category;
        this.rigor_rank = rigor_rank;
        this.image = image;
        this.type = type;
        this.imageName = imageName;
        this.attendees = attendees;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getTypedes() {
        return typedes;
    }

    public void setTypedes(String typedes) {
        this.typedes = typedes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public LocalDateTime getSchedule() {
        return schedule;
    }

    public void setSchedule(LocalDateTime schedule) {
        this.schedule = schedule;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModerator() {
        return moderator;
    }

    public void setModerator(String moderator) {
        this.moderator = moderator;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSub_category() {
        return sub_category;
    }

    public void setSub_category(String sub_category) {
        this.sub_category = sub_category;
    }

    public int getRigor_rank() {
        return rigor_rank;
    }

    public void setRigor_rank(int rigor_rank) {
        this.rigor_rank = rigor_rank;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public User getAttendees() {
        return attendees;
    }

    public void setAttendees(User attendees) {
        this.attendees = attendees;
    }

    @Override
    public String toString() {
        return "Event{" +
                "uid=" + uid +
                ", typedes='" + typedes + '\'' +
                ", name='" + name + '\'' +
                ", tagline='" + tagline + '\'' +
                ", schedule=" + schedule +
                ", description='" + description + '\'' +
                ", moderator='" + moderator + '\'' +
                ", category='" + category + '\'' +
                ", sub_category='" + sub_category + '\'' +
                ", rigor_rank=" + rigor_rank +
                ", image=" + Arrays.toString(image) +
                ", type='" + type + '\'' +
                ", imageName='" + imageName + '\'' +
                ", attendees=" + attendees +
                '}';
    }
}
