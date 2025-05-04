package com.toinfinityandbeyong.ERPMS.interfaces;

import com.toinfinityandbeyong.ERPMS.exception.NotificationException;

public interface Notifiable
{
    void sendNotification(String recipient, String message, String subject) throws NotificationException;
}
