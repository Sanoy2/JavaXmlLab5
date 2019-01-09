package com.company;

public class Person
{
    private String name;
    private String surname;
    private String job;
    private String phone;
    private String mobile;
    private HomeAddress homeAddress;
    private BirthDay birthDay;

    public Person()
    {
        setHomeAddress(new HomeAddress());
        setBirthDay(new BirthDay());
    }


    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public String getJob()
    {
        return job;
    }

    public void setJob(String job)
    {
        this.job = job;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getMobile()
    {
        return mobile;
    }

    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }

    public HomeAddress getHomeAddress()
    {
        return homeAddress;
    }

    public void setHomeAddress(HomeAddress homeAddress)
    {
        this.homeAddress = homeAddress;
    }

    public BirthDay getBirthDay()
    {
        return birthDay;
    }

    public void setBirthDay(BirthDay birthDay)
    {
        this.birthDay = birthDay;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("******************************\n");
        builder.append("Person: ");
        builder.append(name + " " + surname + ", " + job + "\n");
        builder.append(birthDay.toString() + "\n");
        builder.append(homeAddress.toString() + "\n");
        builder.append("Contact:\n");
        builder.append("Phone       : " + phone + "\n");
        builder.append("Mobile phone: " + mobile + "\n");


        return builder.toString();
    }
}
