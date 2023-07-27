package ma.sir.chocho.zynerator.security.common;

public interface SecurityParams {
    public static final String JWT_HEADER_NAME="Authorization";
    public static final String SECRET="ef68ca3c-56fe-44b1-b2fc-73732fc74402";
   // public static final long EXPIRATION=86400000;
    public static final long EXPIRATION=30_000;
    public static final String HEADER_PREFIX="Bearer ";
}
