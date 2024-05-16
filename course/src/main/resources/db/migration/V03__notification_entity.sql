CREATE TABLE notifications (
    id VARCHAR(36) PRIMARY KEY,
    title VARCHAR(255),
    from_email VARCHAR(255),
    subject VARCHAR(255),
    to_email VARCHAR(255),
    read_status BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP
);

INSERT INTO notifications (id, title, from_email, subject, to_email, created_at)
VALUES ('1', 'Nuevo mensaje', 'usuario1@example.com', 'Saludo', 'usuario2@example.com', '2024-05-17 10:00:00');

INSERT INTO notifications (id, title, from_email, subject, to_email, created_at)
VALUES ('2', 'Actualización de estado', 'admin@example.com', 'Actualización importante', 'usuario1@example.com', '2024-05-17 11:30:00');

INSERT INTO notifications (id, title, from_email, subject, to_email, created_at)
VALUES ('3', 'Recordatorio de evento', 'evento@example.com', 'Recordatorio de reunión', 'usuario3@example.com', '2024-05-18 09:45:00');

INSERT INTO notifications (id, title, from_email, subject, to_email, created_at)
VALUES ('4', 'Notificación de entrega', 'venta@example.com', 'Confirmación de envío', 'usuario2@example.com', '2024-05-18 14:20:00');

INSERT INTO notifications (id, title, from_email, subject, to_email, created_at)
VALUES ('5', 'Invitación a evento', 'organizador@example.com', 'Invitación a conferencia', 'usuario1@example.com', '2024-05-19 08:00:00');

INSERT INTO notifications (id, title, from_email, subject, to_email, created_at)
VALUES ('6', 'Oferta especial', 'ofertas@example.com', 'Descuento exclusivo', 'usuario3@example.com', '2024-05-20 12:30:00');

INSERT INTO notifications (id, title, from_email, subject, to_email, created_at)
VALUES ('7', 'Confirmación de pago', 'facturacion@example.com', 'Pago recibido', 'usuario2@example.com', '2024-05-20 15:45:00');

INSERT INTO notifications (id, title, from_email, subject, to_email, created_at)
VALUES ('8', 'Recordatorio de tarea', 'tareas@example.com', 'Recordatorio de tarea pendiente', 'usuario1@example.com', '2024-05-21 10:10:00');

INSERT INTO notifications (id, title, from_email, subject, to_email, created_at)
VALUES ('9', 'Actualización de perfil', 'perfil@example.com', 'Actualización de información', 'usuario3@example.com', '2024-05-21 14:55:00');

INSERT INTO notifications (id, title, from_email, subject, to_email, created_at)
VALUES ('10', 'Confirmación de reserva', 'reservas@example.com', 'Confirmación de reserva de hotel', 'usuario2@example.com', '2024-05-22 09:20:00');
