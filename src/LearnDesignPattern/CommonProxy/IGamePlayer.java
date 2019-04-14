package LearnDesignPattern.CommonProxy;

public interface IGamePlayer {
    //登陆游戏
    public void login(String user, String password);
    //杀怪，网络游戏的主要角色
    public void killBoss();
    //升级
    public void upgrade();
}
