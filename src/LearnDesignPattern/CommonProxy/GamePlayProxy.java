package LearnDesignPattern.CommonProxy;

public class GamePlayProxy implements IGamePlayer {
    private IGamePlayer gamePlayer = null;

    //通过构造函数传递要对谁进行代练
    public GamePlayProxy(String name) {
        try {
            gamePlayer = new GamePlayer(this, name);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        this.upgrade();
    }
}
