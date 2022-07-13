package model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;


public class Member implements Parcelable {
    private int id;
    private String name;

    public Member(int id,String name){
        this.id=id;
        this.name=name;
    }

    protected Member(Parcel in) {
        id = in.readInt();
        name = in.readString();
    }

    public static final Creator<Member> CREATOR = new Creator<Member>() {
        @Override
        public Member createFromParcel(Parcel in) {
            return new Member(in);
        }

        @Override
        public Member[] newArray(int size) {
            return new Member[size];
        }
    };

    @Override
    public java.lang.String toString() {
        return "Member{id="+id+" member="+name+'}';
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
