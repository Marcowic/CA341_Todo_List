#!/usr/bin/env python3

"""
Supposed to be the imperative version of a TODO list (QUEUE)
"""


def remove():
    """
    Iterate through the todo_list and remove the first 'entry' and add it to the done list.
    """
    global todo_list, done_list
    i = 0
    new_list = ""
    while todo_list[i] != "`":
        done_list += todo_list[i]
        i += 1
    i += 1
    while i < len(todo_list):
        new_list += todo_list[i]
        i += 1
    done_list += "`"
    todo_list = new_list

    print("The oldest entry has been removed.")


def check_day(d):
    """
    Checks if the day seems valid.
    """
    dd = int(d)
    if 32 > dd > 0 and len(d) <= 2:
        return True
    raise ValueError


def check_month(m):
    """
    Checks if the month seems valid.
    """
    mm = int(m)
    if 13 > mm > 0 and len(m) <= 2:
        return True
    raise ValueError


def check_year(y):
    """
    Checks if the year is current or within four digits.
    """
    if int(y) >= 2019 and len(y) == 4:
        return True
    raise ValueError


def check_date():
    """
    Checks if the date seems valid, not taking into consideration the max days in particular months and leap years.
    """
    date = ""
    print("Enter the following dd/mm/yyyy :")

    valid_day = False
    while not valid_day:
        try:
            day = input("Day (dd): ")
            valid_day = check_day(day)
            date += day
            date += "/"
        except ValueError:
            print("Invalid day")

    valid_month = False
    while not valid_month:
        try:
            month = input("Month (mm): ")
            valid_month = check_month(month)
            date += month
            date += "/"
        except ValueError:
            print("Invalid month")

    valid_year = False
    while not valid_year:
        try:
            year = input("Year (yyyy): ")
            valid_year = check_year(year)
            date += year
        except ValueError:
            print("Invalid year")
    return date


def check_hour(h):
    hh = int(h)
    if 24 >= hh > 0 and len(h) <=2:
        return True
    raise ValueError


def check_minutes(m):
    mm = int(m)
    if 60 > mm >= 0 and len(m) <= 2:
        return True
    raise ValueError


def check_time():

    time = ""

    print("Enter the time in 24h format.")

    valid_hours = False
    while not valid_hours:
        try:
            hour = input("Hour (hh): ")
            valid_hours += check_hour(hour)
            time += hour
            time += ":"
        except ValueError:
            print("Invalid hour.")

    valid_minutes = False
    while not valid_minutes:
        try:
            minutes = input("Minutes (mm): ")
            valid_minutes += check_minutes(minutes)
            time += minutes
        except ValueError:
            print("Invalid minutes")

    return time

def add():
    """
    Adding an entry to the todo list
    """
    global todo_list
    # Get the entry type
    todo_type = input("What would you like to add? \nEnter \"event\" or \"task\"\n")

    # Events have: date, start time, location
    if todo_type == "event":

        what_task = "<<EVENT>>TITLE: "
        what_task += input("TITLE: ")
        what_task += " DATE: "
        what_task += check_date()
        what_task += " TIME: "
        what_task += check_time()
        what_task += " LOCATION: "
        what_task += input("Enter the location: ")
        todo_list += what_task + "`"
        print("Added event.\n\n")

    # Tasks have: Date, start time, duration, list of people
    elif todo_type == "task":
        what_task = "<<TASK>>TITLE: "
        what_task += input("TITLE: ")
        what_task += " DATE: "
        what_task += check_date()
        what_task += " TIME: "
        what_task += check_time()
        what_task += " Duration: "
        what_task += input("Enter the duration: ")
        what_task += " MEMBERS: "
        what_task += input("Enter the people on the task (separated by comma): ")

        todo_list += what_task + "`"
        print("Added task.\n\n")

    else:
        print("Invalid command \"" + todo_type+"\"")
        print()
    


def display():
    """
    Display the current list of tasks and events on the display output.
    """
    global todo_list, done_list
    print("~"*38 + "<<TODO>>" + "~"*38)
    i = 0
    todo = ""
    while i < len(todo_list):
        if todo_list[i] == "`":
            print(todo)
            todo = ""
        else:
            todo += todo_list[i]
        i += 1
    print()
    print("~"*38 + "<<DONE>>" + "~"*38)
    j = 0
    done = ""
    while j < len(done_list):
        if done_list[j] == "`":
            print(done)
            done = ""
        else:
            done += done_list[j]
        j += 1
    print()


def main():
    global todo_list, done_list
    print("WELCOME TO THE TODO LIST!\n")
    n = ""
    todo_list = ""
    done_list = ""

    while n != "quit":
        if todo_list == "":
            print("There is nothing the TODO list yet!!")

        print("Type \"add\" to add an entry,\"remove\" to remove the oldest entry, \"showme\" to display the todo list, \"quit\" to close the program.\n")
        n = input()
        # Add entry or task

        if n == "add":
            add()

        elif n == "showme":
            display()

        elif n == "remove":
            # Look for the end-of-entry tag for event or task by iterating through the 'todo_list' string -
            # to determine what we can safely remove from the queue.
            # Add what was just removed to the done list
            if len(todo_list) > 0: 
                remove()
        elif n == "quit":
            pass
        else:
            print("Invalid command!")


if __name__ == "__main__":
    main()
    print("Thank you for using the todo list")
    print("Closing program")
