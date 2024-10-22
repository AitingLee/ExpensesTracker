package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Map;

public class ExpensesTracker 
{
    private int income;
    private List<Invoice> yearlyInvoices;

    public ExpensesTracker(int income) {
        this.income = income;
        yearlyInvoices = new ArrayList<Invoice>();
    }

    public void addInvoice(Invoice invoice)
    {
        yearlyInvoices.add(invoice);
    }

    public int monthExpenses(int month)
    {
        var total = 0;
        for(Invoice invoice : yearlyInvoices)
        {
            if(month == invoice.getMonth())
                total += invoice.getAmount();
        }
        return total;
    }

    public int monthSaving(int month)
    {
        return income - monthExpenses(month);
    }


    public void readInvoice()
    {
        var scanner = new Scanner(System.in);
        var day = scanner.nextInt();
        var month = scanner.nextInt();
        var amount = scanner.nextInt();
        var payee = scanner.next();

        var invoice = new Invoice(amount, month, day, payee);
        
        yearlyInvoices.add(invoice);
        scanner.close();
    }

    public void clearMonthInvoices(int month)
    {
        Iterator<Invoice> it = yearlyInvoices.iterator();
        while(it.hasNext())
        {
            Invoice invoice = it.next();
            if(invoice.getMonth() == month)
                it.remove();
        }
    }

    public void listYearlySavings()
    {
        for(int i = 1 ; i <= 12; i++)
        {
            var s = monthSaving(i);
            if(s == 0)
                System.out.println("no saving in month "+ i);
            else
                System.out.println("the saved amount in month "+ i + " is " + s);
        }
    }

    public Map<String,Integer> payeeAmount()
    {
        var result = new HashMap<String,Integer>();
        for(Invoice invoice : yearlyInvoices)
        {
            var payee = invoice.getPayee();
            var originalAmount = 0;
            if(result.containsKey(payee))
            {
                originalAmount = result.get(payee);
            }
            result.put(payee, originalAmount + invoice.getAmount());
        }
        return result;
    }
}
