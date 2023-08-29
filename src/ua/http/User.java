package ua.http;

public class User {
    private int id;
    private String name;
    private String email;
    private Adress adress;
    private String phone;
    private String website;
    private Company company;

    public User() {
    }

    public User(int id, String name, String email, String phone, String website) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.adress = new Adress();
        this.phone = phone;
        this.website = website;
        this.company = new Company();
    }

    class Adress {
        Geo geo;
        String street;
        String suite;
        String city;
        String zipcode;
        public Adress() {
        }
        public Adress(String street, String suite, String city, String zipcode) {
            this.geo = new Geo();
            this.street = street;
            this.suite = suite;
            this.city = city;
            this.zipcode = zipcode;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getSuite() {
            return suite;
        }

        public void setSuite(String suite) {
            this.suite = suite;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getZipcode() {
            return zipcode;
        }

        public void setZipcode(String zipcode) {
            this.zipcode = zipcode;
        }

        class Geo {
            private float lat;
            private float lng;
            public Geo() {
            }
            public Geo(float lat, float lng) {
                this.lat = lat;
                this.lng = lng;
            }

            public float getLat() {
                return lat;
            }

            public void setLat(float lat) {
                this.lat = lat;
            }

            public float getLng() {
                return lng;
            }

            public void setLng(float lng) {
                this.lng = lng;
            }

            @Override
            public String toString() {
                return "Geo{" +
                        "lat=" + lat +
                        ", lng=" + lng +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "Adress{" +
                    "street='" + street + '\'' +
                    ", suite='" + suite + '\'' +
                    ", city='" + city + '\'' +
                    ", zipcode='" + zipcode + '\'' +
                    ", geo=" + geo.toString() +
                    '}';
        }
    }

    class Company {
        String name;
        String catchPhrase;
        String bs;

        public Company() {
        }

        public Company(String name, String catchPhrase, String bs) {
            this.name = name;
            this.catchPhrase = catchPhrase;
            this.bs = bs;
        }

        @Override
        public String toString() {
            return "Company{" +
                    "name='" + name + '\'' +
                    ", catchPhrase='" + catchPhrase + '\'' +
                    ", bs='" + bs + '\'' +
                    '}';
        }
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", adress=" + adress.toString() +
                ", phone='" + phone + '\'' +
                ", website='" + website + '\'' +
                ", company=" + company +
                '}';
    }
}




