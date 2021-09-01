package com.codegym.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Setter
@Getter
@NoArgsConstructor
public class SongDto {
    private Integer id;

    @NotBlank(message = "Tên bài hát không được để trống")
    @Max( value= 800, message = "Tên bài hát không vượt quá 800 kí tự")
    @Pattern(regexp = "r'^[a-zA-Z0-9]*$'", message = "Tên bài hát không chứa kí tự đặc biệt")
    private String nameSong;

    @NotBlank(message = "Tên nghệ sĩ không được để trống")
    @Max(value = 300, message = "Tên nghệ sĩ không vượt quá 300 kí tự")
    @Pattern(regexp = "r'^[a-zA-Z0-9]*$'", message = "Tên nghệ sĩ không chứa kí tự đặc biệt")
    private String nameArtist;

    @NotBlank(message = "Thể loại nhạc  không được để trống")
    @Max(value = 1000, message = "Thể loại nhạc  không vượt quá 1000 kí tự")
    @Pattern(regexp = "^(?=.*[a-zA-Z0-9][,]).*$", message = "Thể loại bài hát chỉ được chứa dấu phẩy (,) không chứa kí tự đặc biệt khác")
    private String kindOfMusic;
}
