package service;

import dao.MusicDao;
import entity.Music;

import java.util.ArrayList;
import java.util.List;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-07-29
 */
public class MusicService {
    MusicDao musicDao = new MusicDao();
    //查询歌单
    public List<Music> findMusic(){
        List<Music> musicList = new ArrayList<>();
        musicList = musicDao.findMusic();
        return musicList;
    }

    //删除选中的音乐
    public int deleteMusicById(int id){

        if(musicDao.deleteMusicById(id) == 1){
            if (musicDao.findLoveMusicOnDel(id)){
                musicDao.removeLoveMusicOnDel(id);
                return 1;
            }
            return 1;
        }
        return 0;
    }
    //根据 ID 查找音乐
    public Music findMusic(int id){
        Music music = new Music();
        music = findMusic(id);
        return music;
    }

    //
    public List<Music> keySecletMusic(String str){
        List<Music> musicList = new ArrayList<>();
        musicList = musicDao.keySelectMusic(str);
        return musicList;
    }
}
