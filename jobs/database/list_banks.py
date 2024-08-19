import psycopg2

def list_banks():
    try:
        # Establish the connection to the PostgreSQL database
        conn = psycopg2.connect(
            dbname="investment",
            user="postgres",
            password="root",
            host="192.168.178.79",
            port="5432"
        )
        
        # Create a cursor object to interact with the database
        cur = conn.cursor()
        
        # Execute the SQL SELECT query
        select_query = "SELECT * FROM banks;"
        cur.execute(select_query)
        
        # Fetch all rows from the executed query
        rows = cur.fetchall()
        
        # Print the result
        for row in rows:
            print(row)
        
    except Exception as e:
        print(f"An error occurred: {e}")
        
    finally:
        # Close the cursor and connection
        if cur:
            cur.close()
        if conn:
            conn.close()

# Run the function
if __name__ == "__main__":
    list_banks()
