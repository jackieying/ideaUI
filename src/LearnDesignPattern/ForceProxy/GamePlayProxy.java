package LearnDesignPattern.ForceProxy;

public class GamePlayProxy implements IGamePlayer {
    private IGamePlayer gamePlayer = null;

    //通过构造函数传递要对谁进行代练
    public GamePlayProxy(IGamePlayer _gamePlayer) {
        this.gamePlayer = _gamePlayer;
    }

    //代练登录
    @Override
    public void login(String user, String password) {
        this.gamePlayer.login(user, password);
    }

    //代练打怪
    @Override
    public void killBoss() {
        this.gamePlayer.killBoss();
    }

    //代练升级
    @Override
    public void upgrade() {
        this.gamePlayer.upgrade();
    }

    //代理的代理暂时还没有，就是自己
    @Override
    public IGamePlayer getProxy() {
        return this;
    }
}
