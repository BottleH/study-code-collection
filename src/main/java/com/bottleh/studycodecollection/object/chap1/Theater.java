package com.bottleh.studycodecollection.object.chap1;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Theater {

    private TicketSeller ticketSeller;

    public void enter(Audience audience) {
        if (audience.getBag().hasInvitation()) {
            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
            audience.getBag().setTicket(ticket);
            return;
        }
        Ticket ticket = ticketSeller.getTicketOffice().getTicket();
        audience.getBag().minusAmount(ticket.getFee());
        ticketSeller.getTicketOffice().plusAmount(ticket.getFee());
        audience.getBag().setTicket(ticket);

    }
}
