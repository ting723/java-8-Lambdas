package com.zhanglw.java8lambdas.chapter3;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.zhanglw.java8lambdas.base.Album;
import com.zhanglw.java8lambdas.base.Artist;
import com.zhanglw.java8lambdas.base.Track;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Author : zhanglianwei
 * Create : 2018/1/23 22:54
 * Update : 2018/1/23 22:54
 * Descriptions :
 */
public class Question1 {

    /**
     * 求和
     *
     * @param numbers
     * @return
     */
    int addUp(Stream<Integer> numbers) {
        return numbers.reduce(0, (acc, y) -> acc + y);
    }

    /**
     * 获取艺术家的国籍和姓名
     *
     * @param artists
     * @return
     */
    List<String> getArtistNation(List<Artist> artists) {
        return artists.stream().flatMap(artist -> Stream.of(artist.getName(), artist.getNationality()))
                .collect(toList());
    }

    /**
     * 获取最多由3首歌曲的专辑组成的列表
     *
     * @param albumList
     * @return
     */
    List<Album> getMaxThreeAlbum(List<Album> albumList) {
        return albumList.stream().filter(album -> album.getTracks() != null && album.getTracks().size() <= 3).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Question1 question1 = new Question1();
        System.out.println(question1.addUp(Stream.of(1, 2, 3, 4)));

        List<Artist> artists = new ArrayList<>();
        artists.add(new Artist("心然", "China"));
        artists.add(new Artist("Taylor Swift", "America"));
        System.out.println(JSON.toJSONString(question1.getArtistNation(artists), SerializerFeature.PrettyFormat));


        List<Album> albumList = new ArrayList<>();
        Album album = new Album();
        album.setName("专辑11");
        album.setTracks(Arrays.asList(new Track("17",188), new Track("20",200)));

        Album album1 = new Album();
        album1.setName("专辑22");
        album1.setTracks(Arrays.asList(new Track("12",188), new Track("20",200),
                new Track("12",188), new Track("20",200)
                ));

        albumList.add(album);
        albumList.add(album1);
        System.out.println(JSON.toJSONString(question1.getMaxThreeAlbum(albumList),SerializerFeature.PrettyFormat));

    }
}
