package brokerageFirm;

public interface Observer {
    /**
     * The method that the subject calls on each observer/subscriber to
     * notify them of the changes in the weather readings.
     * @param	subject		subject
     */
    public void update (final Subject subject);
}
