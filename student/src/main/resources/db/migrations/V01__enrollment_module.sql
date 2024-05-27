create table enrollments (

    id UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
    user_id bigserial not null,
    course_id bigserial not null,
    total double (10,2),
    enrolled_at timestamp default now()

);