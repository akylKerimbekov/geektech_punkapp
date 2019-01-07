package com.geektech.punkapp.core;

import io.realm.Realm;

public class RealmBaseDataSource {

    protected Realm getRealm() {

        return Realm.getDefaultInstance();
    }

    protected void execute(Realm.Transaction transaction) {
        Realm realm = null;
        try {
            realm = getRealm();
            realm.executeTransaction(transaction);
        } catch (Exception e) {
            //Log
        } finally {
            if (realm != null) {
                realm.close();
            }
        }
    }

    protected long getNextId(Class c) {
        Realm realm = null;
        try {
            realm = getRealm();

            String primaryKeyField = realm.getSchema()
                    .get(c.getSimpleName())
                    .getPrimaryKey();

            if (realm.where(c).max(primaryKeyField) == null) {
                return 1;
            }

            return (long) realm.where(c).max(primaryKeyField) + 1;
        } catch (Exception e) {
            return -1;
        } finally {
            if (realm != null) {
                realm.close();
            }
        }
    }

}
