package LearnDesignPattern.ForceProxy;

public interface IGamePlayer {
    //登陆游戏
    public void login(String user, String password);
    //杀怪，网络游戏的主要角色
    public void killBoss();
    //升级
    public void upgrade();
    //每个实例找到自己的代理
    public IGamePlayer getProxy();
}
