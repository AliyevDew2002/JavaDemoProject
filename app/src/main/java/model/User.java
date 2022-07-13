package model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;


public class User implements Parcelable {
    private int id;
    private String name;

    public User(int id,String name){
        this.id=id;
        this.name=name;
    }

    protected User(Parcel in) {
        id = in.readInt();
        name = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String toString(){
        return "User{"+"id="+id+ "  name="+name+"}";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
    }
}
