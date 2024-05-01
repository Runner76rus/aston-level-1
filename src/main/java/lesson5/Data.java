package lesson5;

import java.util.Objects;

public class Data {
    private String code;
    private String version;

    public Data(String code, String version) {
        this.code = code;
        this.version = version;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Data{" + "code='" + code + '\'' + ", version='" + version + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data data = (Data) o;
        return Objects.equals(code, data.code) && Objects.equals(version, data.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, version);
    }
}
