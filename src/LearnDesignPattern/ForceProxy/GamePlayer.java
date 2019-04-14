package LearnDesignPattern.ForceProxy;

public class GamePlayer implements IGamePlayer {
    private String name;
    private IGamePlayer proxy = null;

    private GamePlayer(String _name) {
        this.name = _name;
    }

    @Override
    public IGamePlayer getProxy() {
        this.proxy = new GamePlayProxy(this);
        return this.proxy;
    }

    @Override
    public void login(String user, String password) {
        if (this.isProxyObject()) {
            System.out.println("登录名为" + user + "的用户" + this.name + "登录成功！");
        } else {
            System.out.println("请使用指定的代理类访问！");
        }
    }

    @Override
    public void killBoss() {
        if (this.isProxyObject()) {
            System.out.println(this.name + "在打怪");
        } else {
            System.out.println("请使用指定的代理访问！");
        }
    }

    @Override
    public void upgrade() {
        if (this.isProxyObject()) {
            System.out.println(this.name + " 又升了一级！");
        } else {
            System.out.println("请使用指定的代理访问！");
        }
    }

    //检查是否是代理对象
    private boolean isProxyObject() {
        if (this.proxy == null) {
            return false;
        } else {
            return true;
        }
    }

}
