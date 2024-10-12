import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UserDto } from './entity/user.dto';

@Injectable({
    providenIn: 'root'
})
export class UserService {
    private apiUrl = 'http://localhost:8080/api/user';

    constructor(private http: HttpClient) {
    }

    createUser(user: UserDto): Observable<UserDto> {
        return this.http.post<UserDto>(this.apiUrl, user);
    }

    getUserById(id: number): Observable<UserDto> {
        return this.http.get<UserDto>(`${this.apiUrl}/${id}`);
    }

    getAllUsers(): Observable<UserDto[]> {
        return this.http.get<UserDto[]>(this.apiUrl);
    }

    updateUser(id: number, user: UserDto): Observable<UserDto> {
        return this.http.put<UserDto>(`${this.apiUrl}/${id}`, user);
    }

    deleteUser(id: number): Observable<string> {
        return this.http.delete<string>(`${this.apiUrl}/${id}`);
    }
}