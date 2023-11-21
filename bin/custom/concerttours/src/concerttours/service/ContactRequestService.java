package concerttours.service;


import concerttours.model.ContactRequestModel;

public interface ContactRequestService
{
    ContactRequestModel getContactRequest(String sender);
}